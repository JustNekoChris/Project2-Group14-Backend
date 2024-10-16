package heapdb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table implements ITable {
	
	private List<Tuple> tuples;
	private Schema schema;
	
	public Table(Schema schema) {
		this.schema = schema;
		tuples = new ArrayList<>();
	}
	
	@Override
	public Schema getSchema() {
		return schema;
	}

	
	@Override
	public int size() {
		return tuples.size();
	}

	@Override
	public void close() {
		// do nothing
	}
	
	@Override
	public boolean insert(Tuple rec) {
		if (! rec.getSchema().equals(schema)) {
			throw new IllegalStateException("Error: tuple schema does not match table schema.");
		}
		
		// if schema has no key, then just add the tuple.
		// if schema has key, see if key already exists in table
		
		// TODO
        if (schema.getKey() != null) {
            for (Tuple tuple : tuples) {
                if (tuple.getKey().equals(rec.getKey())) {
                    return false;
                }
            }
        }
        tuples.add(rec);
        return true;
//		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(Object key) {
		if (schema.getKey() == null) {
			throw new IllegalStateException("Error: table does not have a primary key.  Can not delete.");
		}
		
		// TODO
		for (Tuple tuple: tuples) {
			if (tuple.getKey().equals(key)) {
				tuples.remove(tuple);
				return true;
			}
		}
		return false;
//		throw new UnsupportedOperationException();
	}
	

	@Override
	public Tuple lookup(Object key) {
		if (schema.getKey() == null) {
			throw new IllegalStateException("Error: table does not have a primary key.  Can not lookup by key.");
		}

		// TODO
		for (Tuple tuple: tuples) {
			if (tuple.getKey().equals(key)) {
				return tuple;
			}
		}
		return null;
//		throw new UnsupportedOperationException();

	}

	@Override
	public ITable lookup(String colname, Object value) {
		if (schema.getColumnIndex(colname) < 0) {
			throw new IllegalStateException("Error: table does not contain column "+colname);
		}
		// find all tuples that satisfy the predicate colname=value
		// and insert the tuples to result table.
		// return the result		
		
		// TODO
		Table result = new Table(this.getSchema());
		for(Tuple tuple: tuples) {
			if (tuple.get(schema.getColumnIndex(colname)).equals(value)) {
				result.insert(tuple);
			}
		}
		return result;
		// throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<Tuple> iterator() {
		return tuples.iterator();
	}
	
	public String toString() {
		if (tuples.isEmpty()) {
			return "Empty Table";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Tuple t : this) {
				sb.append(t.toString());
				sb.append("\n");
			}
			return sb.toString();
		}
	}
}
