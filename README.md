# SpringJDBCDemo

Driver :-
Driver classes are the utility classes that are used to carry out some task. 
In Java, driver classes are used in JDBC to connect a Java application to a database. 
Driver classes are vendor-specific i. e. MySQL database provides its own driver class,
and Oracle database provides its own class as well.



DriverManager class :- 

The DriverManager class is the component of JDBC API and also a member of the java.sql package.
The DriverManager class acts as an interface between users and drivers. 
It keeps track of the drivers that are available and handles establishing a connection 
between a database and the appropriate driver. 
It contains all the appropriate methods to register and deregister 
the database driver class and to create a connection between a Java application and the database.
The DriverManager class maintains a list of Driver classes that have registered themselves
by calling the method DriverManager.registerDriver(). Note that before interacting with a Database, 
it is a mandatory process to register the driver; otherwise, an exception is thrown.


Connection class
It helps in connecting to database :-


Statement class:-
It will help execute query.

ReusltSet :-
To get the output of the query.



Ways of Database connection -
1. JDBC using plain Java.
2. JDBC using Spring JDBC.
3. Use of JPA
4. Hibernate


1. JDBC using plain Java.  
	Done as an assignment
	
2. JDBC using Spring JDBC.
	It uses the JdbcTemplate
	it is initialized using an object of DataSource (DriverManagerDataSource).
	DataSource holds for us :- Drivername , url, user , password

JdbcTemplate:- 
JdbcTemplate is the central class in the JDBC core package. 
It handles the creation and release of resources, which helps you avoid common errors, 
such as forgetting to close the connection.
It performs the basic tasks of the core JDBC workflow (such as statement creation and execution),
leaving application code to provide SQL and extract results. The JdbcTemplate class:

>Runs SQL queries
>Updates statements and stored procedure calls
>Performs iteration over ResultSet instances and extraction of returned parameter values.
>Catches JDBC exceptions and translates them to the generic, more informative, exception hierarchy defined in the org.springframework.dao package

Mainly 3 types of methods :-
Execute()
Update()
Query methods.
And some more methods to deal with StoredProcedures as well, etc................

----------------------------------------------------------------------------------------------
Execute () and update() are for non select operations on db and query methods are select operations on db.

Methods of Spring JdbcTemplate:-

1 . void execute(“sql")-
This method is used to executed both DDL and DML (non-select) operation on the
database.
This is method allowed only static SQL commands. It means the SQL command
should not contain (?) symbol.
This Is suitable DDL operations on the database because for DML operations , this
method does not return the count value back to the programmer.
Example:- jt.execute(“update emp set sal=2000 where empno=7000”);
In the above method execute() does not inform whether the salary is update(or) not
so for DML operations this execute is not suitable.


2) int update("SQL”);
 int update(“SQL  ?",Object[]):-

 This method is used to execute only DML operation on the db it means either insert
(or) update(or) delete.

if we have single parameter use static sql statement and if more than 1 parameter then use dynamic sql.
In case of multiple parameter (Dynamic sql) we need to pass Object[] as parameter.
See below example to understand :-

Object[] params = {new Integer(1009),"Divyesh"-;
int numberOfRowsUpdated =it.update(“insert into spring values(?,?)”,params);

or
int  numberOfRowsUpdated =it.update(“insert into spring values(?,?)”,new Object[]{new Integer(1009),"Divyesh"});

3) Query methods of jdbc template:-
> int queryForInt(“sql”)  or queryForInt(“sql”,Object[]):
> long queryForLong(“sql”)  or queryForLong(“sql”,Object[]):
> object queryForObject(“sql",Type.class):-
> list queryForList(“sql”) or  list<Type> queryForList(“sql”, Type.class)
List<Integer> empNames = queryForList(“select empId from employee”,Integer.class);

BeanPropertyRowMapper class :-
RowMapper implementation that converts a row into a new instance of the specified mapped target 
class. The mapped target class must be a top-level class and it must have a default or no-arg 
constructor.

Column values are mapped based on matching the column name as obtained from result set metadata
to public setters for the corresponding properties. The names are matched either directly or by 
transforming a name separating the parts with underscores to the same name using "camel" case.

Mapping is provided for fields in the target class for many common types, e.g.: String, boolean, 
Boolean, byte, Byte, short, Short, int, Integer, long, Long, float, Float, double, Double, 
BigDecimal, java.util.Date, etc.

To facilitate mapping between columns and fields that don't have matching names, 
try using column aliases in the SQL statement like "select fname as first_name from customer".

------------------------------------------------------------------------------------------------
Data Access Object Pattern:-

Data Access Object Pattern or DAO pattern is used to separate low-level data accessing API or operations from high-level business services. 

Advantages

1. The advantage of using data access objects is the relatively simple and rigorous separation between two important parts of an application that can but should not know anything of each other, and which can be expected to evolve frequently and independently.

2. If we need to change the underlying persistence mechanism we only have to change the DAO layer and not all the places in the domain logic where the DAO layer is used from.

Disadvantages 

1. Potential disadvantages of using DAO is a leaky abstraction, code duplication, and abstraction inversion.

Design components

BusinessObject: The BusinessObject represents the data client. It is the object that requires access to the data source to obtain and store data. A BusinessObject may be implemented as a session bean, entity bean, or some other Java object in addition to a servlet or helper bean that accesses the data source.
DataAccessObject: The DataAccessObject is the primary object of this pattern. The DataAccessObject abstracts the underlying data access implementation for the BusinessObject to enable transparent access to the data source.
DataSource: This represents a data source implementation. A data source could be a database such as an RDBMS, OODBMS, XML repository, flat file system, and so forth. A data source can also be another system service or some kind of repository.
TransferObject: This represents a Transfer Object used as a data carrier. The DataAccessObject may use a Transfer Object to return data to the client. The DataAccessObject may also receive the data from the client in a Transfer Object to update the data in the data source.


@Repository Annotation
DAO or Repository classes usually represent the database access layer in an application, and should be annotated with @Repository:

@Repository Annotation is a specialization of @Component annotation which is used to indicate 
that the class provides the mechanism for storage, retrieval, update, delete and search operation
on objects. Though it is a specialization of @Component annotation, so Spring Repository classes
are autodetected by spring framework through classpath scanning. 
This annotation is a general-purpose stereotype annotation which very close to the DAO pattern 
where DAO classes are responsible for providing CRUD operations on database tables. 





