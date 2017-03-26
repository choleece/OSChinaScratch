package cn.choleece.oschina.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;

import java.io.Serializable;

/**
 * Created by choleece on 2017/3/25.
 */
@TableBind(tableName = "TKeyword", pkName = "KeywordID")
public class Keyword extends Model<Keyword> {

    private static final long serialVersionID = 1L;

    public static Keyword dao = new Keyword();
}