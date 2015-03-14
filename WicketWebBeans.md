# Introduction to Wicket Web Beans #

Wicket Web Beans (WWB) is an Apache Wicket (http://wicket.apache.org) component toolkit for displaying and editing POJOs that conform to the JavaBeans specification. Web pages are automatically generated based on bean properties and certain conventions. If necessary, the layout, editability, and actions of these pages can be customized on an exception basis. In other words, the toolkit normally does what you'd expect, but when it doesn't, you can override its behavior.

At the highest-level, the com.googlecode.wicketwebbeans.containers.BeanForm component provides rich AJAX form functionality. The form is embedded in a Page designed by you. This allows you to create customized page designs. Also, this allows multiple BeanForms to be incorporated on a single page. At your choosing, other lower-level components may be used independently of BeanForm (e.g., BeanGridPanel). WWB does not try to force you into a certain way of doing things, but BeanForm makes it very convenient to implement a bean-based form if you don't want to go to a lot of extra work. You focus on the model (beans), WWB handles the user interface.

Fields within a form are dynamically sent back to the server-side bean as they are changed, which eliminates the typical submit cycle. This makes WWB act more like a rich client application and less like a standard forms-based application.

Next: [Requirements](Requirements.md)