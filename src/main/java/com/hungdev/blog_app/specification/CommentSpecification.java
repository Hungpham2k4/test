package com.hungdev.blog_app.specification;

import com.hungdev.blog_app.entity.Comment;
import com.hungdev.blog_app.form.CommentFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class CommentSpecification {
    public static Specification<Comment> buildSpec(CommentFilterForm form) {
        return form == null ? null : new Specification<Comment>() {
            @Override
            public Predicate toPredicate(
                    Root<Comment> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder
            ) {
                var predicates = new ArrayList<Predicate>();

                var search = form.getSearch();
                // where name like "%...%" OR email like "%...%"
                if (search != null) {
                    var hasNameLike = builder.like(
                            root.get("name"),
                            "%" + search + "%"
                    );
                    var hasEmailLike = builder.like(
                            root.get("email"),
                            "%" + search + "%"
                    );

                    var predicate = builder.or(hasNameLike, hasEmailLike);
                    predicates.add(predicate);
                }

                var postId = form.getPostId();
                if (postId != null) {
                    var predicate = builder.equal(
                            root.get("post").get("id"), postId
                    );
                    predicates.add(predicate);
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
