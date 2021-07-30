artist.domain
/**
 * Artist object
 * 
 * @author Sai Samarth
 * 
 */
public class Artist {
	/*
	 * Correspond to the artist table
	 */
	
	private String id;
	private String name; 
	private String keyword;
	
	 public Artist(String id, String name, String keyword) {
	        this.id = id;
	        this.name = name;
		this.keyword = keyword;
	    }
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	@Override
	public String toString() {
		return "User [ id=" + id + ", name="
				+ name + ", keyword=" + keyword +"]";
	}
}

