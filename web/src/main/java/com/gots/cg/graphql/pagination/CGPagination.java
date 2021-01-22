package com.gots.cg.graphql.pagination;

import graphql.relay.Edge;
import graphql.relay.PageInfo;
import io.leangen.graphql.execution.relay.Page;
import io.leangen.graphql.execution.relay.generic.GenericPage;
import io.leangen.graphql.execution.relay.generic.PageFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/21 14:04
 */
public class CGPagination<N> extends GenericPage<N> {

    @Getter
    @Setter
    private long totalCount;

    public CGPagination(List<Edge<N>> edges, PageInfo pageInfo, long totalCount) {
        super(edges, pageInfo);
        this.totalCount = totalCount;
    }

    public static <T> CGPagination<T> create(List<T> nodes, long count, long offset) {
        Page<T> p = PageFactory.createOffsetBasedPage(nodes, count, offset);
        return new CGPagination<>(p.getEdges(), p.getPageInfo(), count);
    }

}
