package management.service;

public class Query {
	private String query;
	
	private Query(Builder builder) {
		this.query = builder.query.toString();
	}

	@Override
	public String toString() {
		return query;
	}

	public static class Builder {
		private StringBuilder query;
		
		public Builder() {
			query = new StringBuilder();
		}
		
		public Builder select(String columns) {
			query.append("select ").append(columns).append(" ");
			return this;
		}
		
		public Builder from (String table) {
			query.append("from ").append(table).append(" ");
			return this;
		}
		
		public Builder where(String condition, Object...params) {
			query.append("WHERE ").append(condition).append(" ");
			return this;
		}
		
		public Builder orderBy(String column, boolean asc) {
			query.append("ORDER BY ").append(column).append(asc ? " ASC " : " DESC ");
	        return this;
		}
		
		public Builder insert(String table, String columns, String values) {
			query.append("insert into ").append(table).append(" ");
			query.append("(").append(columns).append(")").append(" ");
			query.append("values (").append(values).append(")").append(" ");
			return this;
		}
		
		public Builder update(String table, String columns, String condition) {
			query.append("update ").append(table).append(" ");
		    query.append("set ").append(columns).append(" ");
		    if (condition != null && !condition.isEmpty()) {
		        query.append("where ").append(condition).append(" ");
		    }
		    return this;
		}
		
		public Builder delete(String table, String condition) {
			query.append("delete from ").append(table).append(" ");
		    if (condition != null && !condition.isEmpty()) {
		        query.append("where ").append(condition).append(" ");
		    }
		    return this;
		}
		
		public Query build() {
			return new Query(this);
		}
	}
}
