package org.sklsft.demo.populator.command.dummy;

import org.sklsft.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.sklsft.demo.api.interfaces.dummy.FoolService;
import org.sklsft.demo.api.model.dummy.forms.FoolForm;
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
public class FoolCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(FoolCommand.class);

@Autowired
private FoolService foolService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<FoolForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<FoolForm>(FoolForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<FoolForm>(FoolForm.class);
}
for (Object[] args : arguments.getArguments()) {
String message = "execute foolService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
FoolForm foolForm = mapper.mapFrom(new FoolForm(), args);

this.foolService.save(foolForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}
