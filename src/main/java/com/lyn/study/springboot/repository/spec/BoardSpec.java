package com.lyn.study.springboot.repository.spec;



import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.lyn.study.springboot.entity.Board;

public class BoardSpec {
/*
	public static Specification<Board> titleLike(final String keyword) {

        return new Specification<Board>() {

            @Override
            public Predicate toPredicate(Root<Board> root,
                    CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get(Board_.title), "%" + keyword + "%");
            }
        };
    }

/*
    public static Specification<Content> category(final Category category) {

        return new Specification<Content>() {

            @Override

            public Predicate toPredicate(Root<Content> root,

                    CriteriaQuery<?> query, CriteriaBuilder cb) {

                return cb.equal(root.get(Content_.category), category);

            }

        };

    }
 */   
}
