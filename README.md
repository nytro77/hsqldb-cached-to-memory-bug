# hsqldb-cached-to-memory-bug
A simple Spring Boot project that reproduces a bug found in HyperSQL 2.6.0 and 2.6.1.

When using a file based hsqldb database it is not possible to create a CACHED table then change its type to MEMORY.
The other way around works just fine.

The problem does not occur in hsqldb 2.5.1.

Bug reported to HSQLDB: https://sourceforge.net/p/hsqldb/bugs/1640/
