/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.web.util;

public class NavigationBarSearch {
	private static int recordPerPage;
	private static int recordCount;
	private static int pageCount;
	private static int pageCurrent;
	private static int recordStartNumber;
	private static int bid;
	private static String searchContents;
	private static int searchType;
	private static String pageUrl;
	private static String barHead="<form name='navigationForm' method='get' action=''>";
	private static String barFirst="<a href='#pageUrl#?bid=#bid#&&pag=1&&searchContents=#searchContents#&&searchType=#searchType#'>[首页]</a>";
	private static String barPrevious="<a href='#pageUrl#?bid=#bid#&&pag=#pagPrevious#&&searchContents=#searchContents#&&searchType=#searchType#'>[上一页]</a>";
	private static String barNext="<a href='#pageUrl#?bid=#bid#&&pag=#pagNext#&&searchContents=#searchContents#&&searchType=#searchType#'>[下一页]</a>";
	private static String barLast="<a href='#pageUrl#?bid=#bid#&&pag=#pagLast#&&searchContents=#searchContents#&&searchType=#searchType#'>[尾页]</a>";
	private static String barInfo="当前页：#pag#/#pagLast#";
	private static String barGoTo="&nbsp;转到"+
															"<input name='pag' type='text' size='3' value='#pageCurrent#'>页"+
															"<input name='bid' type='hidden' value='#bid#'>"+
															"<input name='searchContents' type='hidden' value='#searchContents#'>"+
															"<input name='navigationSubmit' type='submit' value='GO'>";
	private static String barRecordCount="&nbsp;记录总数：#recordCount#&nbsp;";
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
		bar=bar.replaceAll("#bid#", String.valueOf(bid));
		bar=bar.replaceAll("#pag#", String.valueOf(pageCurrent));
		bar=bar.replaceAll("#pagPrevious#", String.valueOf(pageCurrent-1));
		bar=bar.replaceAll("#pagNext#", String.valueOf(pageCurrent+1));
		bar=bar.replaceAll("#pagLast#", String.valueOf(pageCount));
		bar=bar.replaceAll("#recordCount#", String.valueOf(recordCount));
		bar=bar.replaceAll("#searchContents#", String.valueOf(searchContents));
		bar=bar.replaceAll("#searchType#", String.valueOf(searchType));
		bar=bar.replaceAll("#pageCurrent#", String.valueOf(pageCurrent));
		
		return bar;
	}
	
	/**
	 * 初始化导航栏配置信息
	 * @param bid 版块ID
	 * @param pageCurrent 当前页
	 * @param searchType 搜索类型
	 * @param searchContents 搜索内容
	 * @param pageUrl 搜索内容呈现页地址
	 * @param recordPerPage 没页显示的记录数
	 * @param recordCount 总记录数
	 */
	public void init(int bid,
								int pageCurrent,
								int searchType,
								String searchContents,
								String pageUrl,
								int recordPerPage,
								int recordCount){
		this.pageCurrent=pageCurrent;
		this.pageUrl=pageUrl;
		this.bid=bid;
		this.recordPerPage=recordPerPage;
		this.recordCount=recordCount;
		this.searchContents=searchContents;
		this.searchType=searchType;
		
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
