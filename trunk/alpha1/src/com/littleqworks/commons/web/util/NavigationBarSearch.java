/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
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
	private static String barFirst="<a href='#pageUrl#?bid=#bid#&&pag=1&&searchContents=#searchContents#&&searchType=#searchType#'>[��ҳ]</a>";
	private static String barPrevious="<a href='#pageUrl#?bid=#bid#&&pag=#pagPrevious#&&searchContents=#searchContents#&&searchType=#searchType#'>[��һҳ]</a>";
	private static String barNext="<a href='#pageUrl#?bid=#bid#&&pag=#pagNext#&&searchContents=#searchContents#&&searchType=#searchType#'>[��һҳ]</a>";
	private static String barLast="<a href='#pageUrl#?bid=#bid#&&pag=#pagLast#&&searchContents=#searchContents#&&searchType=#searchType#'>[βҳ]</a>";
	private static String barInfo="��ǰҳ��#pag#/#pagLast#";
	private static String barGoTo="&nbsp;ת��"+
															"<input name='pag' type='text' size='3' value='#pageCurrent#'>ҳ"+
															"<input name='bid' type='hidden' value='#bid#'>"+
															"<input name='searchContents' type='hidden' value='#searchContents#'>"+
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
	 * ��ʼ��������������Ϣ
	 * @param bid ���ID
	 * @param pageCurrent ��ǰҳ
	 * @param searchType ��������
	 * @param searchContents ��������
	 * @param pageUrl �������ݳ���ҳ��ַ
	 * @param recordPerPage ûҳ��ʾ�ļ�¼��
	 * @param recordCount �ܼ�¼��
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
