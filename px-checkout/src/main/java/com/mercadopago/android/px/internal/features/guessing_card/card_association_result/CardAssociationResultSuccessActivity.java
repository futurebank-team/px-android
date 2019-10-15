package com.mercadopago.android.px.internal.features.guessing_card.card_association_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import com.mercadolibre.android.ui.widgets.MeliButton;
import com.mercadopago.android.px.R;
import com.mercadopago.android.px.internal.base.BaseActivity;
import com.mercadopago.android.px.internal.util.ViewUtils;
import com.mercadopago.android.px.tracking.internal.views.CardAssociationResultViewTrack;

public class CardAssociationResultSuccessActivity extends BaseActivity {

    public static void startCardAssociationResultSuccessActivity(final Activity callerActivity) {
        final Intent intent = new Intent(callerActivity, CardAssociationResultSuccessActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        callerActivity.startActivity(intent);
    }

    @Override
    public void onPostCreate(@Nullable final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setContentView(R.layout.px_card_association_result_success);

        ViewUtils.setStatusBarColor(ContextCompat.getColor(this, R.color.px_green_status_bar), getWindow());

        final MeliButton exitButton = findViewById(R.id.mpsdkCardAssociationResultExitButton);
        exitButton.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });

        new CardAssociationResultViewTrack(CardAssociationResultViewTrack.Type.SUCCESS).track();
    }
}