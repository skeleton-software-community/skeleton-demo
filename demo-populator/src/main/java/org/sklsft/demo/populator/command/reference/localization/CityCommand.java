package org.sklsft.demo.populator.command.reference.localization;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.sklsft.demo.api.interfaces.reference.localization.CityService;
import org.sklsft.demo.api.model.reference.localization.forms.CityForm;
import org.sklsft.generator.persistence.backup.command.interfaces.BackupArgumentsCommand;
import org.sklsft.generator.persistence.backup.reader.model.BackupArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * auto generated bean populator command class file
 * <br/>no modification should be done to this file
 * <br/>processed by skeleton-generator
 */
@Component
public class CityCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(CityCommand.class);

@Inject
private CityService cityService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<CityForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<CityForm>(CityForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<CityForm>(CityForm.class);
}
for (Object[] args : arguments.getArguments()) {
String message = "execute cityService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
CityForm cityForm = mapper.mapFrom(new CityForm(), args);

this.cityService.save(cityForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}
