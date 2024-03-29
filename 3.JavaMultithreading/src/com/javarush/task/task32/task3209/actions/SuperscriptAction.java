package com.javarush.task.task32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SuperscriptAction extends StyledEditorKit.StyledTextAction{
    /**
     * Creates a new StyledTextAction from a string action name.
     *
     * @param nm the name of the action
     */
    public SuperscriptAction(String nm) {
        super(nm);
    }
    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }

    //10. Метод actionPerformed(ActionEvent actionEvent) класса SuperscriptAction должен использовать
    // метод setSuperscript у StyleConstants с параметрами: SimpleAttributeSet и !StyleConstants.isSuperscript(mutableAttributeSet).

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSuperscript(simpleAttributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }

    }
}
