package org.simpleframework.xml.stream;

import java.util.Iterator;

public abstract interface NodeMap<T extends Node> extends Iterable<String>
{
  public abstract T get(String paramString);

  public abstract String getName();

  public abstract T getNode();

  public abstract Iterator<String> iterator();

  public abstract T put(String paramString1, String paramString2);

  public abstract T remove(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeMap
 * JD-Core Version:    0.6.2
 */