package com.jy.x.chain;

import com.jy.x.chain.specific.*;
import com.jy.x.common.Chain;

/**
 * @program: x
 * @author: Jy
 * @create: 2019-08-07 11:44
 **/
public class GenerateChainContext {

    public static GenerateChain getGenerateChain() {

        GenerateChain readOnlyHandler = new GenerateReadOnlyHandler(Chain.READONLY.getIndex());
        GenerateChain readOnlyImplHandler = new GenerateReadOnlyImplHandler(Chain.READONLYIMPL.getIndex());
        GenerateChain interfaceHandler = new GenerateInterfaceHandler(Chain.INTERFACE.getIndex());
        GenerateChain interfaceImplHandler = new GenerateInterfaceImplHandler(Chain.INTERFACEIMPL.getIndex());
        GenerateChain entityGetSetHandler = new GenerateEntityGetSetHandler(Chain.ENTITYGETSET.getIndex());

        readOnlyHandler.setNextGenerateChain(readOnlyImplHandler);
        readOnlyImplHandler.setNextGenerateChain(interfaceHandler);
        interfaceHandler.setNextGenerateChain(interfaceImplHandler);
        interfaceImplHandler.setNextGenerateChain(entityGetSetHandler);

        return readOnlyHandler;
    }
}
