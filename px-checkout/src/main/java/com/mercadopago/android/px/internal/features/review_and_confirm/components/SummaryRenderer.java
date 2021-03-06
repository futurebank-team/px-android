package com.mercadopago.android.px.internal.features.review_and_confirm.components;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import com.mercadopago.android.px.internal.view.Renderer;
import com.mercadopago.android.px.internal.view.RendererFactory;

public class SummaryRenderer extends Renderer<SummaryComponent> {

    @Override
    public View render(@NonNull final SummaryComponent component, @NonNull final Context context,
        final ViewGroup parent) {

        if ((component.props.summaryModel.hasMultipleInstallments())
            || component.props.summaryModel.hasCoupon()
            || component.props.summaryModel.hasCharges()
            || component.props.reviewAndConfirmConfiguration.hasExtrasAmount()) {
            final Renderer fullSummaryRenderer = RendererFactory.create(context, component.getFullSummary());
            final View fullSummaryView = fullSummaryRenderer.render();
            parent.addView(fullSummaryView);
        } else {
            final Renderer compactSummaryRenderer = RendererFactory.create(context, component.getCompactSummary());
            final View compactSummaryView = compactSummaryRenderer.render();
            parent.addView(compactSummaryView);
        }

        return parent;
    }
}
