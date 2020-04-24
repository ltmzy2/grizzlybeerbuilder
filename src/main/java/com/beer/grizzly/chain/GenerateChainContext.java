package com.beer.grizzly.chain;

import com.beer.grizzly.chain.specific.*;
import com.beer.grizzly.common.Chain;

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
