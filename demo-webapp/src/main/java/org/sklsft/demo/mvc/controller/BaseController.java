package org.sklsft.demo.mvc.controller;

import java.util.Iterator;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;

import org.sklsft.commons.mvc.ajax.AjaxMethodExecutor;
import org.sklsft.commons.mvc.ajax.AjaxMethodTemplate;
import org.sklsft.commons.mvc.messages.MessageHandler;
import org.sklsft.commons.mvc.redirection.RedirectionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController {
	
	protected static final Logger logger = LoggerFactory
			.getLogger(BaseController.class);
		
	/*
	 * properties
	 */
	@Autowired
	private MessageHandler messageHandler;
	
	@Autowired
	private RedirectionHandler redirectionHandler;
	
	@Autowired
	private AjaxMethodExecutor ajaxMethodExecutor;
	
	
	
	protected void redirect(String relativeUrl, boolean keepMessages) {
		
		redirectionHandler.redirect(relativeUrl, keepMessages);
	}
	
	
	protected void redirect(String relativeUrl) {
		
		redirectionHandler.redirect(relativeUrl);
	}
	
	
	protected void redirectToExterior(String url, boolean keepMessages) {

		redirectionHandler.redirectToExterior(url, keepMessages);
	}
	
	
	protected void redirectToExterior(String url) {

		redirectionHandler.redirectToExterior(url);
	}
	
	
	protected void displayInfo(String message) {

		messageHandler.displayInfo(message);
	}
	

	protected void displayWarning(String message) {
		
		messageHandler.displayWarning(message);
	}
	

	protected void displayError(String message) {

		messageHandler.displayError(message);
	}
	
	protected void executeAjaxMethod(String value, AjaxMethodTemplate template) {
		ajaxMethodExecutor.executeAjaxMethod(value, template);
	}
	
	
	public static String getParameter(String parameterName) {

		String parameter = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get(parameterName);
		return parameter;
	}
	
	
	public void resetForm(ActionEvent event)
			throws AbortProcessingException {

		UIComponent component = event.getComponent();
		UIForm form = findParentForm(component);

		if(form != null) {
			clearComponentHierarchy(form);
		}
	}
	

	private UIForm findParentForm(UIComponent component) {
		for (UIComponent parent = component; parent != null; parent = parent
				.getParent()) {
			if (parent instanceof UIForm) {
				return (UIForm) parent;
			}
		}
		return null;
	}
	

	private void clearComponentHierarchy(UIComponent pComponent) {

		if (pComponent instanceof EditableValueHolder) {
			EditableValueHolder editableValueHolder = (EditableValueHolder) pComponent;
			editableValueHolder.resetValue();
		}
		for (Iterator<UIComponent> iterator = pComponent.getFacetsAndChildren(); iterator
				.hasNext();) {
			clearComponentHierarchy(iterator.next());
		}

	}
}