package com.viber.voip.ui.doodle.commands.movable;

import com.viber.voip.ui.doodle.objects.MovableObject;
import com.viber.voip.ui.doodle.undo.Undo;

public class a
  implements com.viber.voip.ui.doodle.commands.a<MovableObject>
{
  public Undo a(MovableObject paramMovableObject, com.viber.voip.ui.doodle.scene.a parama)
  {
    return paramMovableObject.onClick();
  }

  public String toString()
  {
    return "ClickCommand{" + super.toString() + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.commands.movable.a
 * JD-Core Version:    0.6.2
 */