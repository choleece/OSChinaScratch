package cn.choleece.oschina.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName = "TOSNews", pkName="NewsID")
public class News extends Model<News> {
	
	private static final long serialVersionUID = 5091131941785378706L;
	
	public static final News dao = new News();
	
}
