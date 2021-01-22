package com.gots.cg.beans.schema.olp;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/21 12:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OLP_Node extends OLP_Base {

    Set<String> labels;
}
