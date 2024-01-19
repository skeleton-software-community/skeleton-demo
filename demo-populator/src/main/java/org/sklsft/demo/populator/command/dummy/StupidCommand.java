package org.sklsft.demo.populator.command.dummy;

import org.sklsft.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.sklsft.demo.api.interfaces.dummy.StupidService;
import org.sklsft.demo.api.model.dummy.forms.StupidForm;
import org.sklsft.generator.persistence.backup.command.interfaces.BackupArgumentsCommand;
import org.sklsft.generator.persistence.backup.reader.model.BackupArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * auto generated bean populator command class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
@Component
public class StupidCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(StupidCommand.class);

@Autowired
private StupidService stupidService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<StupidForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<StupidForm>(StupidForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<StupidForm>(StupidForm.class);
}
for (Object[] args : arguments.getArguments()) {
String message = "execute stupidService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
StupidForm stupidForm = mapper.mapFrom(new StupidForm(), args);

this.stupidService.save(stupidForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}
