package ch.course223.advanced.domainmodels.article;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

@Document(indexName = "blog", type = "article")
public class Article {
    @Id
    private String id;

    private String title;

   /* @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authors;*/

}
