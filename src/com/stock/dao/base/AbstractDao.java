package com.stock.dao.base;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.stock.utils.Sqls;

public abstract class AbstractDao<T, PK> extends StockJDBCDao implements
		BaseMapper<T> {

	protected abstract Class<T> getClassType();

	public abstract T findById(T o);

	public abstract void save(T o);

	public abstract void update(T o);

	public abstract void delete(T o);

	public Integer queryForInt(String sqlName, Object... arg) {
		return getJdbcTemplate().queryForInt(getSql(sqlName,arg), arg);
	}

	public T queryForObject(String sqlName, Object... arg) {
		return queryForObject(sqlName, this, arg);
	}

	public T queryForObject(String sqlName, final BaseMapper<T> freeBaseMapper,	Object... arg) {
		return getJdbcTemplate().queryForObject(getSql(sqlName,arg), new RowMapper<T>() {
			@Override
			public T mapRow(ResultSet rs, int row) throws SQLException {
				return freeBaseMapper.baseMapper(rs, row);
			}

		}, arg);
	}
	
	public List<T> queryForObjectList(String sqlName,	Object... arg)
	{
		return queryForObjectList(sqlName,this,arg);
	}
	public List<T> queryForObjectList(String sqlName, final BaseMapper<T> freeBaseMapper,	Object... arg)
	{
		return this.getJdbcTemplate().query(getSql(sqlName,arg), new RowMapper<T>(){
			public T mapRow(ResultSet rs, int row) throws SQLException {
				return freeBaseMapper.baseMapper(rs, row);
			}},arg);
	}
	
	private String getSql(String sqlName,Object...arg)
	{
		String sql = Sqls.getSql(sqlName);
		Sqls.showPara(sqlName, sql, arg);
		return sql;
	}
	
	
	

}
