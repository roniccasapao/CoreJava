package com.java.bootcamp.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgentParser {
	private String browserName;
	private String browserVersion;
	private List<UserAgentDetails> parsedBrowsers = new ArrayList<UserAgentDetails>();

	private static Pattern pattern = Pattern
			.compile("([^/\\s]*)(/([^\\s]*))?(\\s*\\[[a-zA-Z][a-zA-Z]\\])?"
					+ "\\s*(\\((([^()]|(\\([^()]*\\)))*)\\))?\\s*");

	/**
	 * Parses the incoming user agent string into useful data about the browser
	 * and its operating system.
	 * 
	 * @param userAgentString
	 *            the user agent header from the browser.
	 */
	public UserAgentParser(String userAgentString) {
		Matcher matcher = pattern.matcher(userAgentString);

		while (matcher.find()) {
			String nextBrowserName = matcher.group(1);
			String nextBrowserVersion = matcher.group(3);
			String nextBrowserComments = null;
			if (matcher.groupCount() >= 6) {
				nextBrowserComments = matcher.group(6);
			}
			parsedBrowsers.add(new UserAgentDetails(nextBrowserName,
					nextBrowserVersion, nextBrowserComments));
		}

		if (parsedBrowsers.size() > 0) {
			processBrowserDetails();
		} else {

		}

	}

	/**
	 * Wraps the process of extracting browser name, version, and operating
	 * sytem.
	 */
	private void processBrowserDetails() {

		String[] browserNameAndVersion = extractBrowserNameAndVersion();
		browserName = browserNameAndVersion[0];
		browserVersion = browserNameAndVersion[1];
	}

	private String[] extractBrowserNameAndVersion() {

		String[] knownBrowsers = new String[] { "firefox", "netscape",
				"chrome", "safari", "camino", "mosaic", "opera", "galeon" };

		for (UserAgentDetails nextBrowser : parsedBrowsers) {
			for (String nextKnown : knownBrowsers) {
				if (nextBrowser.getBrowserName().toLowerCase()
						.startsWith(nextKnown)) {
					return new String[] { nextBrowser.getBrowserName(),
							nextBrowser.getBrowserVersion() };
				}
				// TODO might need special case here for Opera's dodgy version
			}

		}
		UserAgentDetails firstAgent = parsedBrowsers.get(0);
		if (firstAgent.getBrowserName().toLowerCase().startsWith("mozilla")) {

			if (firstAgent.getBrowserComments() != null) {
				String[] comments = firstAgent.getBrowserComments().split(";");
				if (comments.length > 2
						&& comments[0].toLowerCase().startsWith("compatible")) {
					String realBrowserWithVersion = comments[1].trim();
					int firstSpace = realBrowserWithVersion.indexOf(' ');
					int firstSlash = realBrowserWithVersion.indexOf('/');
					if ((firstSlash > -1 && firstSpace > -1)
							|| (firstSlash > -1 && firstSpace == -1)) {
						// we have slash and space, or just a slash,
						// so let's choose slash for the split
						return new String[] {
								realBrowserWithVersion.substring(0, firstSlash),
								realBrowserWithVersion
										.substring(firstSlash + 1) };
					} else if (firstSpace > -1) {
						return new String[] {
								realBrowserWithVersion.substring(0, firstSpace),
								realBrowserWithVersion
										.substring(firstSpace + 1) };
					} else { // out of ideas for version, or no version supplied
						return new String[] { realBrowserWithVersion, null };
					}
				}
			}

			// Looks like a *real* Mozilla :-)
			if (new Float(firstAgent.getBrowserVersion()) < 5.0) {
				return new String[] { "Netscape",
						firstAgent.getBrowserVersion() };
			} else {
				// TODO: get version from comment string
				return new String[] { "Mozilla",
						firstAgent.getBrowserComments().split(";")[0].trim() };
			}
		} else {
			return new String[] { firstAgent.getBrowserName(),
					firstAgent.getBrowserVersion() };
		}
	}

	public String getBrowserName() {
		return browserName;
	}
	
	public String getBrowserVersion() {
		return browserVersion;
	}
}
