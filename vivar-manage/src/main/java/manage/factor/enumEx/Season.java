package manage.factor.enumEx;

public enum Season {

	
	 SPRING("sp", "spring", "Mùa xuân"), 
	 SUMMER("sm", "summer", "Mùa hạ"),
	 AUTUMN("at", "autumn", "Mùa thu"), 
	 WINTER("wt", "winter", "Mùa đông");
	 

	private String code;
	private String codeEnglish;
	private String codeVietnames;
	

	private Season(String code, String codeEnglish, String codeVietnames) {
		this.code = code;
		this.codeEnglish = codeEnglish;
		this.codeVietnames = codeVietnames;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeEnglish() {
		return codeEnglish;
	}

	public void setCodeEnglish(String codeEnglish) {
		this.codeEnglish = codeEnglish;
	}

	public String getCodeVietnames() {
		return codeVietnames;
	}

	public void setCodeVietnames(String codeVietnames) {
		this.codeVietnames = codeVietnames;
	}

}
