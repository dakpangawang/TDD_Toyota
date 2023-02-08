package toyota.tdd.utils;

public class AutoData {

	private String landingPageTitle;
	private String setYourLocationPageTitle;
	private String buildYourToyotaTitle;

	public AutoData(String landingPageTitle, String setYourLocationPageTitle, String buildYourToyotaTitle) {
		if (landingPageTitle == null || setYourLocationPageTitle == null || buildYourToyotaTitle == null
				|| landingPageTitle.length() == 0 || setYourLocationPageTitle.length() == 0
				|| buildYourToyotaTitle.length() == 0) {
			throw new NullPointerException();
		} else {
			this.landingPageTitle = landingPageTitle;
			this.setYourLocationPageTitle = setYourLocationPageTitle;
			this.buildYourToyotaTitle = buildYourToyotaTitle;
		}
	}

	public String getLandingPageTitle() {
		return landingPageTitle;
	}

	public String getSetYourLocationPageTitle() {
		return setYourLocationPageTitle;
	}

	public String getBuildYourToyotaTitle() {
		return buildYourToyotaTitle;
	}

}
