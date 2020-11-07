package org.fhossyl.packets

import org.fhossyl.packets.common.MetadataType

private typealias Type = MetadataType

enum class BedrockMetadata(val type: Type) {

    Flags(Type.Flags),
    Health(Type.Int),
    Variant(Type.Int),
    Color(Type.Byte),
    NameTag(Type.String),
    OwnerEid(Type.Long),
    TargetEid(Type.Long),
    AirSupply(Type.Short),
    EffectColor(Type.Int),
    EffectAmbient(Type.Byte),
    JumpDuration(Type.Byte),
    HurtTime(Type.Int),
    HurtDirection(Type.Int),
    RowTimeLeft(Type.Float),
    RowTimeRight(Type.Float),
    ExperienceValue(Type.Int),
    DisplayItem(Type.Int),
    DisplayOffset(Type.Unknown), // Can be an integer or a long value
    CustomDisplay(Type.Byte),
    Swell(Type.Unknown),
    SwellDirection(Type.Unknown),
    OldSwell(Type.Unknown),
    ChargeAmount(Type.Byte),
    CarriedBlock(Type.Int),
    ClientEvent(Type.Byte),
    UsingItem(Type.Byte),
    PlayerFlags(Type.Byte),
    EndermanHeldItemId(Type.Int),
    EntityAge(Type.Byte),
    CanStartSleep(Type.Byte),
    PlayerIndex(Type.Int),
    BedPosition(Type.Vector3I),
    XPower(Type.Float),
    YPower(Type.Float),
    ZPower(Type.Float),
    AuxPower(Type.Unknown),
    FishX(Type.Unknown),
    FishZ(Type.Unknown),
    FishAngle(Type.Unknown),
    LeashHolderEid(Type.Long),
    Scale(Type.Float),
    HasNpcComponent(Type.Byte),
    SkinId(Type.String),
    NpcSkinId(Type.String),
    NpcData(Type.Unknown),
    UrlTag(Type.String),
    MaxAirSupply(Type.Short),
    MarkVariant(Type.Int),
    ContainerType(Type.Byte),
    ContainerBaseSize(Type.Int),
    ContainerStrengthModifier(Type.Int),
    BlockTarget(Type.Vector3I),
    WitherInvulnerableTicks(Type.Int),
    WitherTarget1(Type.Long),
    WitherTarget2(Type.Long),
    WitherTarget3(Type.Long),
    WitherAerialAttack(Type.Short),
    BoundingBoxWidth(Type.Float),
    BoundingBoxHeight(Type.Float),
    FuseLength(Type.Int),
    RiderSeatPosition(Type.Vector3F),
    RiderRotationLocked(Type.Byte),
    RiderMaximumRotation(Type.Float),
    RiderMinimumRotation(Type.Float),
    AreaEffectCloudRadius(Type.Float),
    AreaEffectCloudWaiting(Type.Int),
    AreaEffectCloudParticleId(Type.Int),
    ShulkerPeakHeight(Type.Int),
    ShulkerAttackFace(Type.Byte),
    ShulkerAttackPos(Type.Vector3I),
    TradingPlayerEid(Type.Long),
    CommandBlockEnabled(Type.Byte),
    CommandBlockCommand(Type.String),
    CommandBlockLastOutput(Type.String),
    CommandBlockTrackOutput(Type.Byte),
    ControllingRiderSeatNumber(Type.Byte),
    Strength(Type.Int),
    MaxStrength(Type.Int),
    EvokerSpellColor(Type.Int),
    LimitedLife(Type.Int),
    ArmorStandPoseIndex(Type.Int),
    EnderCrystalTimeOffset(Type.Int),
    AlwaysShowNameTag(Type.Byte),
    Color2(Type.Byte),
    ScoreTag(Type.String),
    BalloonAttachedEntity(Type.Long),
    PufferFishSize(Type.Byte),
    BoatBubbleTime(Type.Int),
    AgentId(Type.Long),
    SittingAmount(Type.Unknown),
    SittingAmountPrevious(Type.Unknown),
    EatingCounter(Type.Int),
    LayingAmount(Type.Unknown),
    LayingAmountPrevious(Type.Unknown),
    EatCounter(Type.Int),
    Flags2(Type.Flags),
    AreaEffectCloudDuration(Type.Int),
    AreaEffectCloudSpawnTime(Type.Int),
    AreaEffectCloudRadiusPerTick(Type.Float),
    AreaEffectCloudChangeOnPickup(Type.Float),
    AreaEffectCloudCount(Type.Int),
    InteractiveTag(Type.String),
    TradeTier(Type.Int),
    MaxTradeTier(Type.Int),
    TradeXP(Type.Int),
    SpawningFrames(Type.Unknown),
    CommandBlockTickDelay(Type.Int),
    CommandBlockExecuteOnFirstTick(Type.Byte),
    AmbientSoundInterval(Type.Float),
    AmbientSoundIntervalRange(Type.Float),
    AmbientSoundEventName(Type.String),
    FallDamageMultiplier(Type.Float),
    NameRawText(Type.Unknown),
    CanRideTarget(Type.Byte),
    LowTierCuredTradeDiscount(Type.Int),
    HighTierCuredTradeDiscount(Type.Int),
    NearbyCuredTradeDiscount(Type.Int),
    NearbyCuredDiscountTimeSharp(Type.Int),
    Hitbox(Type.NBT),
    IsBuoyant(Type.Byte),
    BuoyantData(Type.Unknown);

}