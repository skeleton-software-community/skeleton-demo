package org.sklsft.demo.populator.command.reference.localization;

import javax.inject.Inject;

import org.sklsft.commons.mapper.impl.ObjectArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.impl.StringArrayToBeanMapperImpl;
import org.sklsft.commons.mapper.interfaces.ObjectArrayToBeanMapper;
import org.sklsft.demo.api.interfaces.reference.localization.RegionService;
import org.sklsft.demo.api.model.reference.localization.forms.RegionForm;
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
public class RegionCommand implements BackupArgumentsCommand {

/*
 * logger
 */
private static final Logger logger = LoggerFactory.getLogger(RegionCommand.class);

@Inject
private RegionService regionService;

@Override
public void execute(BackupArguments arguments) {
ObjectArrayToBeanMapper<RegionForm> mapper;
if (arguments.isArgumentsTyped()) {
mapper = new ObjectArrayToBeanMapperImpl<RegionForm>(RegionForm.class);
} else {
mapper = new StringArrayToBeanMapperImpl<RegionForm>(RegionForm.class);
}
for (Object[] args : arguments.getArguments()) {
String message = "execute regionService.save - args : ";
for (Object arg:args) {
message += "[" + arg + "]";
}
logger.info(message);

try {
RegionForm regionForm = mapper.mapFrom(new RegionForm(), args);

this.regionService.save(regionForm);
} catch (Exception e) {
logger.error(message + "failed : " + e.getClass().getSimpleName() + " - " + e.getMessage(), e);
}
}
}
}
