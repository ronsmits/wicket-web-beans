/*---
   Copyright 2008 Visual Systems Corporation.
   http://www.vscorp.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
   
        http://www.apache.org/licenses/LICENSE-2.0
   
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
---*/

package net.sourceforge.wicketwebbeans.model;

import java.beans.PropertyChangeEvent;

/**
 * Specialization of PropertyBinder that handles updating bound Components. If an Ajax-based RequestCycle
 * is active and the second bean is a Wicket Component, the component is added as
 * a component to update.<p>.
 * 
 * @author Dan Syrstad
 */
public class AjaxPropertyBinder extends PropertyBinder
{

    /**
     * Construct a AjaxPropertyBinder.
     * 
     *  @see PropertyBinder
     */
    public AjaxPropertyBinder(Object listenBean, Object updateBean, PropertyProxy listenProperty,
                    PropertyProxy updateProperty, String eventPropertyName)
    {
        super(listenBean, updateBean, listenProperty, updateProperty, eventPropertyName);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event)
    {
        super.propertyChange(event);
        // TODO
    }
}
