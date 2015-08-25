/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.jdbc;

import java.sql.*;

/**
 * DbConnecter.java
 * @author ̷����
 * @version 0.04
 * Date modified: 11-Jun-07
 * @description �������ݿ�ķ�����.
 */

public class Conn{
	private String dbUsername="root";
	private String dbPassword="ziqiang%net";
	private String dbUrl="localhost:3306";
	private String dbCharset="gb2312";
	private String dbDriver="com.mysql.jdbc.Driver";

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private int count;
	
	/**
	 * ��ʼ��������Ϣ���û��������룬URL���ַ�����).
	 * <br>Ĭ��ֵ��<br>
	 * root<br>
	 * Password:<br>
	 * URL:localhost:3006<br>
	 * Charset:gb2312
	 */

	public String getDbCharset() {
		return dbCharset;
	}

	public void setDbCharset(String dbCharset) {
		this.dbCharset = dbCharset;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	/**
	 * ��ʼ������.
	 * @return
	 */
	public final boolean init(String dbName){
		if(dbName==null)
			return false;
		
		try{
			Class.forName(dbDriver);
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
			return false;
		}

		try{
			String dbUrl="jdbc:mysql://"+this.dbUrl+"/"+dbName+"?useUnicode=true&characterEncoding="+dbCharset;
			conn=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			if((conn==null)||(stmt==null))
			//Connection to MySQL failed
				return false;
			return true;
		}catch(SQLException e2){
			e2.printStackTrace();
			return false;
		}
	}

	/**
	 * ִ��һ����ѯ.
	 * @return
	 */
	public final boolean executeQuery(String sql){
		try{
			rs=stmt.executeQuery(sql);
			//	Count of records
			rs.last();
			count=rs.getRow();
			rs.first();
			return true;
		}catch(SQLException e1){
			e1.printStackTrace();
			return false; 
		}catch(NullPointerException  e2){
			e2.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Execute a SQL.
	 * @return false if fail.
	 */
	public final boolean executeSQL(String sql){
		try{
			stmt.execute(sql);
			return true;
		}catch(SQLException e1){
			e1.printStackTrace();
			return false; 
		}catch(NullPointerException  e2){
			e2.printStackTrace();
			return false;
		}
	}
	
	public final int getCount(){
		return count;
	}

	/**
	 * �ƶ���굽 <i>row</i>.
	 * @return
	 */
	public final boolean goTo(int row){
		try{
			rs.absolute(row);
			return true;
		}catch(SQLException e1){
			e1.printStackTrace();
			return false;
		}
	}
	
	/**
	 * �ƶ���굽��һ��.
	 * @return
	 */
	public final boolean first(){
		try{
			rs.first();
			return true;
		}catch(SQLException e1){
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * �ƶ���굽���һ��.
	 * @return.
	 */
	public final boolean last(){
		try{
			rs.last();
			return true;
		}catch(SQLException e1){
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * �ƶ���굽��һ��.
	 * @return
	*/
	public final boolean next(){
		try{
			rs.next();
			return true;
		}catch(SQLException e1){
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * �ƶ���굽��һ��.
	 * @return
	 */
	public final boolean previous(){
		try{
			rs.previous();
			return true;
		}catch(SQLException e1){
			e1.printStackTrace();
			return false;
		}
	}

	/**
	 * �õ���ǰ���λ�ô���<i>columnIndex</i>ָ�������е��ַ�������.
	 * @param columnIndex Column number
	 * @return
	 */
	public final String getString(int columnIndex){
		try{
			return rs.getString(columnIndex);
		}catch(SQLException e1){
			e1.printStackTrace();
			return null;
		}
	}

	/**
	 * �õ���ǰ���λ�ô���Ϊ<i>columnName</i>�����е��ַ�������.
	 * @param columnName ����
	 * @return ����String������
	 */
	public final String getString(String columnName){
		try{
			return rs.getString(columnName);
		}catch(SQLException e1){
			e1.printStackTrace();
			return null;
		}
	}

	/**
	 * �õ���ǰ���λ�ô���<i>columnIndex</i>ָ�������е���������.
	 * @param columnIndex �к�
	 * @return
	 */
	public final int getInt(int columnIndex){
		try{
			return rs.getInt(columnIndex);	
		}catch(SQLException e1){
			e1.printStackTrace();
			return 0;
		}
	}

	/**
	 * �õ���ǰ���λ�ô���Ϊ<i>columnName</i>�����е���������.
	 * @param columnName ����
	 * @return
	 */
	public final int getInt(String columnName){
		try{
			return rs.getInt(columnName);	
		}catch(SQLException e1){
			e1.printStackTrace();
			return 0;
		}
	}

	/**
	 * �õ���ǰ���λ�ô���<i>columnIndex</i>ָ�������еĸ���������.
	 * @param columnIndex �к�
	 * @return
	 */
 	public final float getFloat(int columnIndex){
		try{
			return rs.getFloat(columnIndex);
		}catch(SQLException e1){
			e1.printStackTrace();
			return 0;
		}
	}

 	/**
 	 * �õ���ǰ���λ�ô���Ϊ<i>columnName</i>�����еĸ���������.
 	 * @param columnName ����
 	 * @return
 	 */
	public final float getFloat(String columnName){
		try{
			return rs.getFloat(columnName);
		}catch(SQLException e1){
			e1.printStackTrace();
			return 0;
		}
	}

	/**
	 * �رյ�ǰ�򿪵�����. 
	 * @return
	 */
	public final boolean close(){
		try{
			rs.close();			
		}catch(SQLException e1){
			e1.printStackTrace();
		}try{
			stmt.close();
		}catch(SQLException e2){
			e2.printStackTrace();
		}try{
			conn.close();
			conn=null;
			return true;
		}catch(SQLException e3){
			e3.printStackTrace();
			return false;
		}
	}

	/**
	 * ���ַ������ַ���ת���������ݿ���ַ���.
	 * <br>���ݿ��ַ�������setConn���������ã�Ĭ��Ϊgb2312. 
	 * @param strsrc ԭ�����ַ���
	 * @return ���ʧ�ܣ�����null.
	 */
	public String convertCharset(String strsrc){
		try{
			if(strsrc==null)
				return null;
			strsrc=new String(strsrc.getBytes("ISO8859_1"),dbCharset);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return strsrc;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

