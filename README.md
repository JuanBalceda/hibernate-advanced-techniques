# hibernate-advanced-techniques
Advanced Hibernate techniques for Mapping Sets, Lists, Embeddable, Enums and Inheritance.

## Inheritance mapping guidance
* Best performance with queries and write operations
    * **Single table** 
* Good performance for queries of subclasses and data integrity
    * **Table per class** or **Mapped Superclass**
* Normalized databases design and data integrity
    * **Joined table**

## Inheritance mapping comparison

Scale of 1 - 4 
- 1 star: the worst
- 4 stars: the best

|                                                      | Single Table | Table per class | Joined Table | Mapped Superclass |
| :--------------------------------------------------: | :----------: | :-------------: | :----------: | :---------------: | 
| Performance: write operations - insert/update/delete |   * * * *    |     * * *       |    *         |      * * * *      |
| Performance: query concrete subclass                 |   * * * *    |     * * * *     |    *         |      * * * *      |
| Performance: polymorphic query                       |   * * * *    |     *           |    *         |      *            |
| Normalized database design                           |   *          |     * * *       |    * * * *   |      * * *        |
| Data integrity (Supports NOT NULL column constraints)|   *          |     * * *       |    * * * *   |      * * * *      |
