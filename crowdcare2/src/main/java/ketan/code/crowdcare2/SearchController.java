package ketan.code.crowdcare2;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SearchController {
	   @RequestMapping(value = "/query/{title}", method = RequestMethod.GET)
	    public @ResponseBody ArrayList<SearchResult> doSearch(@PathVariable("title") String title){
		    title = title.replace(' ', '+');
	    	Search search = new Search(title);
	    	ArrayList<SearchResult> res = search.doWikiQuery();
	    	return res;
	    }
}
