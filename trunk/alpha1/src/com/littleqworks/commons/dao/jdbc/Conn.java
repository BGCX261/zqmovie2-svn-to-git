/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.jdbc;

import java.sql.*;

/**
 * DbConnecter.java
 * @author 谭孟泷
 * @version 0.04
 * Date modified: 11-Jun-07
 * @description 连接数据库的方法类.
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
	 * 初始化连接信息（用户名，密码，URL，字符集）).
	 * <br>默认值：<br>
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
	 * 初始化连接.
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
	 * 执行一个查询.
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
	 * 移动光标到 <i>row</i>.
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
	 * 移动光标到第一项.
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
	 * 移动光标到最后一项.
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
	 * 移动光标到下一项.
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
	 * 移动光标到上一项.
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
	 * 得到当前光标位置处由<i>columnIndex</i>指定的列中的字符型数据.
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
	 * 得到当前光标位置处名为<i>columnName</i>的列中的字符型数据.
	 * @param columnName 列名
	 * @return 返回String型数据
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
	 * 得到当前光标位置处由<i>columnIndex</i>指定的列中的整型数据.
	 * @param columnIndex 列号
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
	 * 得到当前光标位置处名为<i>columnName</i>的列中的整型数据.
	 * @param columnName 列名
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
	 * 得到当前光标位置处由<i>columnIndex</i>指定的列中的浮点型数据.
	 * @param columnIndex 列号
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
 	 * 得到当前光标位置处名为<i>columnName</i>的列中的浮点型数据.
 	 * @param columnName 列名
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
	 * 关闭当前打开的连接. 
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
	 * 将字符串的字符集转换成语数据库的字符集.
	 * <br>数据库字符集可在setConn方法中设置，默认为gb2312. 
	 * @param strsrc 原来的字符串
	 * @return 如果失败，返回null.
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

