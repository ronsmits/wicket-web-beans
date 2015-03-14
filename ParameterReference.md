# WWB beanprops Parameter Reference #

Note that any parameter value may contain a properties file macro reference in the form: _${propertyName}_.  This references a Wicket properties file property. For example:

```
    label: "Text before ${some.Property} text after";
```

## Standard Bean Parameters ##
  * **label** - Specifies a label for the bean.

  * **actions** - a comma-separated list of action method names that define the actions available for the bean. This is a list of action methods available on the Wicket Page or component that the bean is embedded in. These actions can be referenced as "action.{action-method-name}" in props. Actions not included in the "props" parameter are considered to be "global" actions and they appear outside of any tabs. These methods must be public and have the following signature:
```
 	public void <i>doSomething</i>(AjaxRequestTarget target, Form form, Object bean)
```
The target parameter may be null for non-Ajax requests.

  * **props** - This is a list of properties that may have parameters and are presented on the page in the order specified. Any other properties not specified are presented at the end of the page. Properties beginning with "action." refer to actions defined in "actions:" above, not to bean properties. If the property name begins with "-", it tells WWB not to display it. The "EMPTY" pseudo-property name can be used to provide an empty field (e.g., a blank cell in a grid). Configuration may be specified for each property within "{}" - see Standard Property Parameters below.

  * **tabs** - a comma-separated list of tab names and optional parameters for each tab (see Standard Tab Parameters below).

  * **displayed** - Either "true" or "false" to tell WWB whether to display the bean. This is only useful on nested beans.

  * **viewOnly** - Either "true" or "false" to tell WWB whether the bean is view-only or editable by default. This overrides the viewOnly parameter on the BeanMetaData constructor. Individual properties in **props** may override this default.

  * **cols** - Number of columns in the grid. Though not strictly a "standard" parameter, this is a property parameter supported by BeanGridPanel, which is the default layout used by BeanForm. See BeanGridPanel parameters for more details.

  * **rows** - If the bean or bean's IModel passed to BeanForm is a List, this is the number of rows to be displayed in a single page. The default is 10.

  * **css** - CSS class to be used for the bean container.

  * **dynamicCss** - Dynamic CSS class method name to be used for the bean. This method must exist on your component and have the signature: public String methodName(<BeanClass> bean, BeanMetaData beanMetaData). See [CssPage](http://code.google.com/p/wicket-web-beans/source/browse/trunk/wicketwebbeans-examples/src/main/java/com/googlecode/wicketwebbeans/examples/css/CssPage.java) for an example.

  * **container** - a container component to use in place of the default BeanGridPanel or BeanTablePanel. This container must be a Panel and implement a constructor of the form:

public Constructor(String id, final Object bean, BeanMetaData beanMetaData, TabMetaData tabMetaData)

where id = Wicket component ID
bean = the bean, or IModel containing the bean
beanMetaData = the BeanMetaData for bean
tabMetaData = the tab metadata

## Standard Property Parameters ##
  * **label** - Specifies the label for the property.

  * **labelImage** - An image file name relative to the component. Specifies that the property's field should have the specified image rather than a text label.

  * **viewOnly** - Either "true" or "false" to tell WWB whether the property is view-only (i.e., not editable).

  * **fieldType** - Specifies a Field class name to use for this property. This overrides the Field type defined for the property type in ComponentRegistry. Note that if the Field type is already defined for a different class in ComponentRegistry, you can just specify the base class name, not the package which is optional. Otherwise, you can explicitly specify the package name.

  * **elementType** - For Collections, elementType is the type of the elements contained within the collection. By default, WWB automatically deduces the element type from the collection if it is not null and not empty. In this case, elementType is detected from the first element of the collection. Otherwise, you can use this parameter to explicitly specify the type.

  * **colspan** - Number of columns to span in the grid. Though not strictly a "standard" parameter, this is a property parameter supported by BeanGridPanel, which is the default layout used by BeanForm. See BeanGridPanel parameters for more details.

  * **required** - Either "true" or "false" to tell WWB whether the field is required. Note that you must call BeanForm.validateRequired() in your action method to have the validation occur. This is automatically set to true if you are using JPA and the @Column annotation has nullable set to false. If you are using the JDO @Column annotation, this is set to true if @Column.allowsNull is "false".

  * **maxlength** - The maximum input length for a field. This is automatically set if you are using the JPA or JDO @Column.length annotation.

  * **defaultValue** - The default string value for a field. This is automatically set if you are using the JDO @Column.defaultValue annotation.

Actions (action.action-name) additionally support the following parameters (supported by BeanActionButton):

  * **confirm** - Defines a Javascript confirmation message to display when the button is clicked. If answer is "Yes", the action proceeds, otherwise it is canceled.

  * **ajax** - If "true", the action should be invoked with Ajax. Otherwise, it the action performs a regular form submit.

  * **default** - If "true", the action will be fired when the Enter key is pressed anywhere on the form.

  * **rows** - the number of rows to display in a BeanTableField or TextAreaField.

  * **css** - CSS class to be used for the bean container.

  * **dynamicCss** - Dynamic CSS class method name to be used for the bean. This method must exist on your component and have the signature: public String methodName(<BeanClass> bean, ElementMetaData elementMetaData propertyMetaData). See [CssPage](http://code.google.com/p/wicket-web-beans/source/browse/trunk/wicketwebbeans-examples/src/main/java/com/googlecode/wicketwebbeans/examples/css/CssPage.java) for an example.

## Standard Tab Parameters ##

  * **label** - Specifies the label for the property.

  * **props** - Specifies the properties and order of the properties for the tab. This is specified exactly as in the Bean "props" parameter (see Standard Bean Properties).

## Container-specific Parameters ##

### BeanGridPanel ###

> Displays its properties in a grid. The grid is evenly spaced across the width of the window.

  * **cols** - Number of columns in the grid. Default is 3.

  * **colspan** - May be specified on individual properties. This is the number of columns to span in the grid. Default is 1.

### BeanTablePanel ###

Displays a collection of beans in a table. Each property of the bean is a column in the table. The table also allows sorting of bean properties that are Comparable (which includes primitive and wrapper types). Note that BeanTableField (a Field for properties that are collections) allows a "rows" parameter to be specified for the table.

## Property/Field-specific Parameters ##

### BeanGridField ###

Displays a bean in a box with a label. No field-level parameters. This is the default field for properties whose type is otherwise not mapped in ComponentRegistry.

### BeanInCollapsibleField ###

Displays a bean in a collapsible box with a label. No field-level parameters.

### BeanInlineField ###

Displays a bean inline with other fields on the parent bean. No field-level parameters.

### BeanTableField ###

Displays a property's collection as a list of beans in a table. See BeanTablePanel.

  * **rows** - the number of rows to display in the table. Default is 10.

### BeanWithParentLabelField ###

A Field that presents a property's bean in a panel, but the bean's properties do not have labels. For errors, the bean's properties use the parent property's label. This is useful for creating simple composite fields directly from small beans. No field-level parameters.

### DateTimeField ###

  * **format** - the format of the date. The default format is based on the property type:
> > java.util.Date, java.sql.Timestamp: yyyy-MM-dd HH:MM
> > java.sql.Time: HH:MM
> > java.sql.Date: yyyy-MM-dd
> > java.util.Calendar: yyyy-MM-dd HH:MM z


> You may override this defaults in the enclosing Page's properties using the following keys:
> DateTimeField.date.format - Format for java.sql.Date.
> DateTimeField.datetime.format - Format for java.sql.Timestamp or java.util.Date.
> DateTimeField.time.format - Format for java.sql.Time.
> DateTimeField.datetimetz.format - Format for java.util.Calendar types.

### EnumField/JavaEnumField ###

> _Deprecated_
  * **default** - specifies the default value to use from the enumeration. This value must match a value returned from the name() method.
  * Since [revision 414](https://code.google.com/p/wicket-web-beans/source/detail?r=414), please use **defaultValue** instead. **default** is still supported for backwards compatibility, but **defaultValue** takes precedence if present.

### InputField ###

A common field used to accept input for a variety of primitive and wrapper property types.

  * **advOnEnter** - If "true" this tells WWB to advance to the next field when the Enter key is pressed.

### TextAreaField ###

Defines a field for Strings that allows more than one line of input.

  * **rows** - The number of rows (lines) to be displayed for the field. Note that the input is not limited to this number of lines because a scrollbar is used. This is simply the number of lines displayed.  Default is the CSS defined height.

  * **cols** - The number of columns (characters) across to be displayed for the field. Default is the CSS defined width.

## Third-Party Annotations ##

Certain JDO and JPA annotations are supported. Right now, certain attributes of the @Column annotation are supported. See _Standard Property Parameters_ above for more details. Also see the !~~com.googlecode.wicketwebbeans.examples.thirdpartyannotations.AnnotationsBeanPage~~ example _(deprecated)_.

For annotations to be effective at runtime, you **must** have the JDO or JPA annotation classes in your classpath. For web apps, this means having the appropriate JARs in your WEB-INF/lib directory.