package com.gots.cg.beans.schema.olp;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/1/21 12:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OLP_Link extends OLP_Base {

  OLP_Node source;
  OLP_Node target;
}
