package org.nrg.xnat.turbine.modules.actions;

import org.apache.log4j.Logger;
import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;

public class FhirEncounterModifyAction extends ModifySubjectAssessorData {

    static Logger logger = Logger.getLogger(FhirEncounterModifyAction.class);

    /* (non-Javadoc)
     * @see org.apache.turbine.modules.actions.VelocityAction#doPerform(org.apache.turbine.util.RunData, org.apache.velocity.context.Context)
     */
    public void doPerform(RunData data, Context context) throws Exception {
        logger.info("YEAH!!!");
        super.doPerform(data, context);
    }
}
