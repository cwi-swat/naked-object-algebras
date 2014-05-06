package noa.demo.syn;

import noa.demo.alg.ExpAlg;
import noa.demo.alg.ProgAlg;

public interface AllAlg<P, E> extends ProgAlg<P, E>, ExpAlg<E> { 
}

