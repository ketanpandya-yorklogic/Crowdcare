package ketan.code.crowdcare2;

class SearchResult{
	final private String title;
	final private String url;
	
	SearchResult(String title, String url){
		this.title=title;
		this.url=url;
	}
	public String getTitle(){
		return title;
	}
	public String getUrl(){
		return url;
	}
}
