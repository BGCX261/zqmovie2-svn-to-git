package com.littleqworks.commons.web.util;

public class NavigationBarNoParameter {
	private static int recordPerPage;
	private static int recordCount;
	private static int pageCount;
	private static int pageCurrent;
	private static int recordStartNumber;
	private static String pageUrl;
	private static String barHead="<form name='navigationForm' method='get' action=''>";
	private static String barFirst="<a href='#pageUrl#?&pag=1'>[��ҳ]</a>";
	private static String barPrevious="<a href='#pageUrl#?&pag=#pagPrevious#'>[��һҳ]</a>";
	private static String barNext="<a href='#pageUrl#?&pag=#pagNext#'>[��һҳ]</a>";
	private static String barLast="<a href='#pageUrl#?&pag=#pagLast#'>[βҳ]</a>";
	private static String barInfo="��ǰҳ��#pag#/#pagLast#";
	private static String barGoTo="&nbsp;ת��"+
															"<input name='pag' type='text' size='3' value='#pageCurrent#'>ҳ"+
															"<input name='bid' type='hidden' value='#bid#'>"+
															"<input name='status' type='hidden' value='#status#'>"+
															"<input name='navigationSubmit' type='submit' value='GO'>";
	private static String barRecordCount="&nbsp;��¼������#recordCount#&nbsp;";
	private static String barFooter="</form>";
	private static String bar=null;

	public String getNavigationBar(){
		if(pageCount==1){
			bar=barHead+barInfo+barRecordCount+barFooter;
			return replace();
		}
		
		if(pageCurrent==pageCount){
			bar=barHead+barFirst+barPrevious+barInfo+barGoTo+barRecordCount+barFooter;
			return replace();
		}
		
		if(pageCurrent==1){
			bar=barHead+barNext+barLast+barInfo+barGoTo+barRecordCount+barFooter;
			return replace();
		}
		
		bar=barHead+barFirst+barPrevious+barNext+barLast+barInfo+barGoTo+barRecordCount+barFooter;
		return replace();
	}

	private String replace(){
		bar=bar.replaceAll("#pageUrl#", pageUrl);
		bar=bar.replaceAll("#pag#", String.valueOf(pageCurrent));
		bar=bar.replaceAll("#pagPrevious#", String.valueOf(pageCurrent-1));
		bar=bar.replaceAll("#pagNext#", String.valueOf(pageCurrent+1));
		bar=bar.replaceAll("#pagLast#", String.valueOf(pageCount));
		bar=bar.replaceAll("#recordCount#", String.valueOf(recordCount));
		bar=bar.replaceAll("#pageCurrent#", String.valueOf(pageCurrent));
		
		return bar;
	}
	
	public void init(int pageCurrent,String pageUrl,int recordPerPage,int recordCount){
		this.pageCurrent=pageCurrent;
		this.pageUrl=pageUrl;
		this.recordPerPage=recordPerPage;
		this.recordCount=recordCount;
		
		if(recordCount<=recordPerPage){
			pageCount=1;
		}else{
			pageCount=((recordCount%recordPerPage)==0)?(recordCount/recordPerPage):recordCount/recordPerPage+1;
		}
		
		recordStartNumber=(pageCurrent-1)*recordPerPage;
	}

	public int getRecordEndNumber() {
		return recordPerPage;
	}

	public int getRecordStartNumber() {
		return recordStartNumber;
	}
}
