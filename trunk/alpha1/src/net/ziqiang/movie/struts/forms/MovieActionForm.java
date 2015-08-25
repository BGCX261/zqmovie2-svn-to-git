package net.ziqiang.movie.struts.forms;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;
import net.ziqiang.movie.domain.movie.Movie;
import net.ziqiang.movie.domain.movie.Category;

public class MovieActionForm extends ValidatorForm{
	private static final ArrayList<LabelValueBean> STATUS=new ArrayList<LabelValueBean>();
	private List status;
	private List categories;
	private Movie movie;
	private FormFile theFile;
	static{
		STATUS.add(new LabelValueBean("Œ¥…Û∫À","0"));
		STATUS.add(new LabelValueBean("“—…Û∫À","2"));
	}
	
	public MovieActionForm(){
		status=STATUS;
	}
	public List getStatus() {
		return status;
	}
	public void setStatus(List status) {
		this.status = status;
	}

	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categoryLi) {
		if(categoryLi!=null){
			Iterator<Category> it=categoryLi.iterator();
			ArrayList CATEGORIES =new ArrayList();
			while(it.hasNext()){
				Category cate=it.next();
				HashMap hashmap=new HashMap();
				hashmap.put("value",cate.getCategoryId());
				hashmap.put("label",cate.getName());
				CATEGORIES.add(hashmap);
			}
			this.categories=CATEGORIES;
		}else{
			throw new NullPointerException("categoryLi is null");
		}
	}
	public FormFile getTheFile() {
		return theFile;
	}
	public void setTheFile(FormFile theFile) {
		this.theFile = theFile;
	}
}	
