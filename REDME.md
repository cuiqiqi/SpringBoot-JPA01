**关于JPA的一些知识：**

JPA是Java Persistence API的简称，是Java持久层的API，是JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体[对象持久化](https://baike.baidu.com/item/%E5%AF%B9%E8%B1%A1%E6%8C%81%E4%B9%85%E5%8C%96/7316192)到数据库中。JPA 是 Hibernate 的一个抽象，就像 JDBC 和 JDBC 驱动的关系。

JPA的总体思想和现有Hibernate、TopLink、JDO等ORM框架大体一致。总的来说，JPA包括以下3方面的技术：

**ORM映射元数据**

JPA支持XML和[JDK](https://baike.baidu.com/item/JDK)5.0注解两种元数据的形式，元数据描述对象和表之间的映射关系，框架据此将实体[对象持久化](https://baike.baidu.com/item/%E5%AF%B9%E8%B1%A1%E6%8C%81%E4%B9%85%E5%8C%96)到数据库表中；

**API**

用来操作实体对象，执行CRUD操作，框架在后台替代我们完成所有的事情，开发者从繁琐的JDBC和SQL代码中解脱出来。

**查询语言**

这是持久化操作中很重要的一个方面，通过[面向对象](https://baike.baidu.com/item/%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1)而非面向数据库的查询语言查询数据，避免程序的SQL语句紧密耦合。

**JPA的基本注解：**

**@Entity** ：修饰实体类，指明该类将映射到指定的数据表，例如：Customer 类默认的数据表名为 customer

**@Table** ：当实体类与映射的数据库表名不同名时需要使用 @Table 注解，该注解与 @Entity 注解并列使用，使用其**name 属性**指明数据库的表名

```java
@Table(name = "表名")
```



**@Id** ：标识该属性为**主键**，**一般标注在该属性的 getter 方法上**

**@GeneratedValue** ：标注**主键的生成策略**，通过其 **strategy 属性**。通常与 @Id 注解一起使用。默认情况下 JPA 会自动选择一个最适合底层数据库的主键生成策略，MySQL 默认为 AUTO，常用策略有：

```java
@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
```

–IDENTITY：采用数据库 ID自增长的方式来自增主键字段，Oracle 不支持这种方式；

–**AUTO**： **JPA自动选择合适的策略，是默认选项；**

–SEQUENCE：通过序列产生主键，通过 @SequenceGenerator 注解指定序列名，MySql 不支持这种方式

–TABLE：通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植

**@Basic** ：用于**没有任何标注的 getXxx() 方法**，默认即为 @Basic,所以若一个 getter 方法无任何注解，可以使用 @Basic 注解，也可以不使用

**@Column** ：当**实体的属性与其映射的数据表的列不同名时使用**，一般用于 getter 方法上。其 **name 属性用来指明此属性在数据表中对应的列名**；**unique 属性**指明**是否为唯一约束**；**nullable 属性**用来**指明是否可以为空，false 为不能为空**；**length 属性**指明**此列的长度**。

```java
@Column(nullable = false, length = 50) // 映射为字段，值不能为空
```

**@Transient** ：**标注此注解后在创建数据表的时候将会忽略该属性**  Customer 类并没有 info 这个属性，所以数据库中也不应该有 info 这个字段

**@Temporal** ：向数据库**映射日期（Date）属性时用来调整映射的精度**。Date 类型的数据有 DATE, TIME, 和 TIMESTAMP 三种精度(即单纯的日期,时间,或者两者兼备).

@Basic : 懒加载

```java
@Basic(fetch = FetchType.LAZY) // 懒加载
```

一对一关系：

```java
@OneToOne(cascade = CascadeType.ALL)
```

一对多关系：

```java
//拥有mappedBy注解的实体类为关系被维护端
@OneToMany(mappedBy = "   ",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
```

多对多关系：

```java
@ManyToMany
@JoinTable(name = "  ",joinColumns = @JoinColumn(name = "  ") 
 //@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端
```





