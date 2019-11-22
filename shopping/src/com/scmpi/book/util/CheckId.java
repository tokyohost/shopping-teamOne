package com.scmpi.book.util;
import java.sql.*;
public class CheckId {
	
	public  static Integer  getOid(String tableName) throws Exception{

		  ResultSet rs=null;
		  try{
	
		   int i=1;
		   //下面的代码是判断表中有没有记录
		   String sql2="select order_id from "+tableName;
		   rs=DBUtil.queryData(sql2);
		   boolean b=rs.next();//b=true[证明表中有数据，则要进行更新]b=false[表中没有数据，则就要进行插入]
		   if(!b){
		    //表中没有数据，我就插入
		     String sql1="insert into "+tableName+"(order_id) values("+i+")";
		     DBUtil.Update(sql1);
		     //我查询刚插入的记录,rs结果集重新赋值
		     String sql4="select order_id from "+tableName;
		     rs=DBUtil.queryData(sql4);
		     rs.next();
		   }else{
		    //表中有数据，我从结果集中拿出，下面的更新要在次基础上加一
		    int j=rs.getInt(1);
		    String sql3="update "+tableName+" set order_id ="+(j+1);
		    DBUtil.Update(sql3);
		 
		    //我查选刚更新的记录,rs结果集重新赋值
		    String sql5="select order_id from "+tableName;
		    rs=DBUtil.queryData(sql5);
		    rs.next();
		   }
		   int oid=rs.getInt(1);//从rs结果集中拿我要的数据
		   return oid;
		  }finally{
		  
		  }
		 }


}
