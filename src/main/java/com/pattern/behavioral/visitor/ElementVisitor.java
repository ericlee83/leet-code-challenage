package com.pattern.behavioral.visitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ElementVisitor implements Visitor{
    @Override
    public void visit(XmlElement xe) {
        log.info("processing xml element with uuid: " + xe.uuid);
    }

    @Override
    public void visit(JsonElement je) {
        log.info("processing json element with uuid: " + je.uuid);
    }
}
