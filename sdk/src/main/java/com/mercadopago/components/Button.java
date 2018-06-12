package com.mercadopago.components;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.mercadolibre.android.ui.widgets.MeliButton;
import javax.annotation.Nonnull;

public abstract class Button extends CompactComponent<Button.Props, Button.Actions> {

    public interface Actions {
        void onClick(final Action action);
    }

    public static class Props {

        public final Action action;
        public final String label;

        public Props(final String label, final Action action) {
            this.action = action;
            this.label = label;
        }

    }

    public Button(final Props props, final Actions callBack) {
        super(props, callBack);
    }

    public abstract MeliButton getButtonView(@NonNull final Context context);

    @Override
    public View render(@Nonnull final ViewGroup parent) {
        final MeliButton view = getButtonView(parent.getContext());
        view.setText(props.label);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                getActions().onClick(props.action);
            }
        });
        return view;
    }
}