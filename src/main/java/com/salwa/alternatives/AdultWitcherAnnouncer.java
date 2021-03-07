package com.salwa.alternatives;

import javax.enterprise.inject.Alternative;

@Alternative
public class AdultWitcherAnnouncer implements WitcherAnnouncer {
    @Override
    public String announce() {
        return "Get ready to save the word from an emperor of Nilfgaard!!";
    }
}
