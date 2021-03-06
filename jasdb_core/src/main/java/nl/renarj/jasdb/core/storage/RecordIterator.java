/*
 * The JASDB software and code is Copyright protected 2011 and owned by Renze de Vries
 * 
 * All the code and design principals in the codebase are also Copyright 2011 
 * protected and owned Renze de Vries. Any unauthorized usage of the code or the 
 * design and principals as in this code is prohibited.
 */
package nl.renarj.jasdb.core.storage;

import java.util.Iterator;

/**
 * Simple iterator that goes through all the matching record results
 */
public interface RecordIterator extends Iterable<RecordResult>, Iterator<RecordResult> {
	void reset();

    void close();
}