package org.pentaho.ui.xul.binding;

import java.beans.PropertyChangeListener;
import java.lang.ref.Reference;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.pentaho.ui.xul.binding.BindingConvertor.Direction;

public interface Binding {

  public enum Type {
    ONE_WAY, BI_DIRECTIONAL
  };

  void setBindingType(Type t);

  Type getBindingType();

  void initialize();

  Reference getSource();

  void setSource(Object source);

  Reference getTarget();

  void setTarget(Object target);

  String getSourceAttr();

  void setSourceAttr(String sourceAttr);

  String getTargetAttr();

  void setTargetAttr(String targetAttr);

  Object evaluateExpressions(Object val);

  Object doConversions(Object val, Direction dir);

  BindingConvertor getConversion();

  void setConversion(BindingConvertor conversion);

  boolean isReverseConversion();

  void setReverseConversion(boolean reverseConversion);

  void fireSourceChanged() throws IllegalArgumentException, IllegalAccessException,
      InvocationTargetException;

  void bindForward();

  void bindReverse();

  void destroyBindings();

  PropertyChangeListener getForwardListener();

  void setForwardListener(PropertyChangeListener forwardListener);

  PropertyChangeListener getReverseListener();

  void setReverseListener(PropertyChangeListener reverseListener);

  List<PropertyChangeListener> getListeneners();

  BindingContext getContext();

  void setContext(BindingContext context);

}
