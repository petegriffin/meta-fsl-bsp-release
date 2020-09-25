# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by NXP"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require linux-imx-src-${PV}.inc

SRC_URI += "file://0001-MLK-22253-1-Revert-MLK-22094-usb-cdns3-include-head-.patch;md5sum=c8fc29470eacc4ee477afb19774bd00e" 
SRC_URI += "file://0002-MLK-22253-2-Revert-MLK-18579-1-usb-cdns3-using-upstr.patch;md5sum=930963856d91161d1cb284dcada7fa4b" 
SRC_URI += "file://0003-MLK-22253-3-Revert-usb-common-Simplify-usb_decode_ge.patch;md5sum=77abe29dfa7b61784fdcea15aff48422" 
SRC_URI += "file://0004-MLK-22253-4-Revert-usb-common-Patch-simplify-usb_dec.patch;md5sum=23536480493496175355e9de936875eb" 
SRC_URI += "file://0005-MLK-22253-5-Revert-usb-common-change-debug-message-A.patch;md5sum=c0cfa0d677d3f19c6a4417cb17ce7e1f" 
SRC_URI += "file://0006-MLK-22138-VPU-Decoder-distinguish-seek-and-resolutio.patch;md5sum=d9e63560c3aded321a89e5ee77c45f7d" 
SRC_URI += "file://0007-MLK-22141-VPU-Decoder-fix-consumed-length-calculatio.patch;md5sum=401b21f3e34825607a73484fdb8bfaf8" 
SRC_URI += "file://0008-MLK-22163-VPU-Decoder-constraint-value-range-of-colo.patch;md5sum=81786a748040255a1834a0a18b205650" 
SRC_URI += "file://0009-MLK-22165-VPU-Decoder-ignore-the-invalid-timestamp-o.patch;md5sum=035aa5c9088d657a89a121e2beadec1e" 
SRC_URI += "file://0010-MLK-22189-VPU-Decoder-fix-hang-after-set-trick-mode.patch;md5sum=15cbf34eea08a28e863d94551e0bfe7f" 
SRC_URI += "file://0011-MLK-22164-VPU-Decoder-check-input-frame-type-before-.patch;md5sum=b80a8081cf56b32bc0bb0ba6dc70e508" 
SRC_URI += "file://0012-MLK-22195-VPU-Decoder-ensure-when-framework-update-s.patch;md5sum=f79c648d3a73dc069aed62147f6916a1" 
SRC_URI += "file://0013-MLK-22206-VPU-Decoder-modify-vpu-log-print-method.patch;md5sum=1d3e21fdb5b2983c73b1928bd76d62c8" 
SRC_URI += "file://0014-MLK-22038-don-t-clear-instance-before-reset-firmware.patch;md5sum=fcdf1c77a848b9569b6412e0e6e72a08" 
SRC_URI += "file://0015-MLK-22038-VPU-Decoder-cancel-work-when-suspend.patch;md5sum=9bdda3e86a16ca0825e6e3cff56d1af9" 
SRC_URI += "file://0016-MLK-22251-VPU-Decoder-send-fw-reset-cmd-directly.patch;md5sum=e3c6eb8ed09f62d6f0dfca4bc20c2463" 
SRC_URI += "file://0017-MLK-22250-VPU-Decoder-get-seq-info-from-event-data-i.patch;md5sum=7f0c5a45da0a702e8ad74da85fba1eb9" 
SRC_URI += "file://0018-MLK-22257-VPU-Decoder-clear-pending-cmd-if-cmd-is-ti.patch;md5sum=4f201db6335d17109d3ad67fd7dd7c01" 
SRC_URI += "file://0019-MLK-22112-1-arm64-dts-imx8mm-decrease-the-iomem-rang.patch;md5sum=95c2c3467db432ffee98ec2af22bc922" 
SRC_URI += "file://0020-MLK-22112-2-arm64-dts-define-resets-property-for-mip.patch;md5sum=9f1f41fafdbde085a24b807a89f99b21" 
SRC_URI += "file://0021-MLK-22112-3-media-mipi_csi-replace-reset-flow-for-ph.patch;md5sum=b03b3179b0d913b4f03e523b834bf1d4" 
SRC_URI += "file://0022-MLK-22040-clk-imx-enable-qspi-clock-if-m4-enabled-on.patch;md5sum=d39814b2d4e370b7b40ea0a82a1a927e" 
SRC_URI += "file://0023-MLK-22086-clk-imx-Keep-the-root-clock-gate-always-en.patch;md5sum=b2775bb14ee2e4e1d1208516c30cb597" 
SRC_URI += "file://0024-arm64-dts-freescale-Disable-the-csi_bridge-node-in-m.patch;md5sum=3fb75d4439404c8aa4369ae474ae9951" 
SRC_URI += "file://0025-staging-android-ion-Support-cpu-access-during-dma_bu.patch;md5sum=acf44e38b3ed98d13e4fafcd6e4a8ac0" 
SRC_URI += "file://0026-staging-android-ion-fix-sys-heap-pool-s-gfp_flags.patch;md5sum=8821c3f5418a8fed9a8f23968f99111e" 
SRC_URI += "file://0027-MA-12602-Add-ION-carveout-heap-support-on-4.14-kerne.patch;md5sum=8ffca59246997e7fb5f6b21c77d56cb6" 
SRC_URI += "file://0028-MA-12602-2-Add-ION-carveout-heap-support-on-4.14-ker.patch;md5sum=ff3aad9b2b06484bacd03df8ce44db37" 
SRC_URI += "file://0029-MA-12602-3-Add-ION-carveout-heap-support-on-4.14-ker.patch;md5sum=e8c96ecea0d080609905ab916bc6fc31" 
SRC_URI += "file://0030-MA-12122-Enlarge-ION-carveout-memory-address-alignme.patch;md5sum=0343103fd6998ff0de1c3bac8a6bb0ce" 
SRC_URI += "file://0031-MA-12702-Add-vmap-and-vunmap-to-ION-driver.patch;md5sum=682c9af0dbdc26e4fe5872ab152688f3" 
SRC_URI += "file://0032-uapi-Add-ion.h-to-userspace.patch;md5sum=712856c375e46df309af4e4aaa8e828e" 
SRC_URI += "file://0033-MMIOT-153-Enable-ION-unmapped-heap-support-on-4.14-k.patch;md5sum=952a314a2ce63deab75c72567c92cf7d" 
SRC_URI += "file://0034-Started-to-integrate-ion-monitor-in-4.14.patch;md5sum=11a2feef8a667cae454810b39670430d" 
SRC_URI += "file://0035-Ion-monitor-enhancements.patch;md5sum=44cb5554a6537bdb5384c46ebb8792aa" 
SRC_URI += "file://0036-Enable-ION-monitor.patch;md5sum=01d19d1afffc12fa0ffe43d7c84bea1b" 
SRC_URI += "file://0037-MMIOT-459-hdmi-Add-support-for-6-audio-channels.patch;md5sum=96aa7bf41fbc33bde2b76c95a06629db" 
SRC_URI += "file://0038-MMIOT-117-Start-optee-driver-earlier-to-allow-linux-.patch;md5sum=8ae0f6c6e99cc293d249c97a1ee8ad0d" 
SRC_URI += "file://0039-MMIOT-117-Add-control-of-HDMI-HDCP-registers-using-O.patch;md5sum=0412da9bc4f3e3088a8e7c8249724576" 
SRC_URI += "file://0040-ion-unmapped-do-not-reset-ion-buffer.patch;md5sum=3551034228d63330f83940ae27abffd2" 
SRC_URI += "file://0041-MMIOT-192-VU-hantro-linux-driver-Use-OPTEE-Kernel-AP.patch;md5sum=c966a071aed0c0c9cfd72d493283bb3c" 
SRC_URI += "file://0042-MMIOT-192-Handle-IRQ-in-secure.patch;md5sum=61b9d4e9db9db3c30ac1a34f9dd18462" 
SRC_URI += "file://0043-MMIOT-192-Block-control-use-of-Secure-VPU-driver.patch;md5sum=e7bfb152ce552d08b3506ab90126bbb6" 
SRC_URI += "file://0044-MMIOT-192-Add-shared-mem-optim-code-refactoring.patch;md5sum=78887d53d86277d60b713da344fae30c" 
SRC_URI += "file://0045-MMIOT-192-hantro-decoder-Add-support-for-imx8mq.patch;md5sum=e58f31143ed15956a90ec38cdf899bd7" 
SRC_URI += "file://0046-MMIOT-192-Hantro-secure-code-optimization-refactorin.patch;md5sum=124622caaf682c82c73ba5bf74790f61" 
SRC_URI += "file://0047-MMIOT-193-Add-PTA_HANTRO_VPU_CMD_READ_MULTIPLE-comma.patch;md5sum=7e024237a6b5225d9d84da9f052c7cc6" 
SRC_URI += "file://0048-MMIOT-192-Remove-CONFIG_MXC_HANTRO_SECURE-by-default.patch;md5sum=415b9e5fedeba9cc0c79fdb46bf7f7ac" 
SRC_URI += "file://0049-hantrodec-driver-init-start-level-set-to-late-init.patch;md5sum=f630a67e9512b44032d0ae943faf08c2" 
SRC_URI += "file://0050-Hantro-secure-decoder-add-performance-counters.patch;md5sum=eda7948ab29d0873337fa9688f9da7b5" 
SRC_URI += "file://0051-MMIOT-413-Add-fsl-imx8mq-evk-optee.dts.patch;md5sum=5eb8d59dce2551f86f6dcafa79c1eb7f" 
SRC_URI += "file://0052-MMIOT-388-increase-private-region-size-in-shmem.patch;md5sum=c76f837684cb85eff15ab49ec3c13451" 

SRC_URI += "file://secure_vpu.cfg"

DEPENDS += "lzop-native bc-native"

DEFAULT_PREFERENCE = "1"

DO_CONFIG_V7_COPY = "no"
DO_CONFIG_V7_COPY_mx6 = "yes"
DO_CONFIG_V7_COPY_mx7 = "yes"
DO_CONFIG_V7_COPY_mx8 = "no"

EXTRA_KERNEL_CONFIG = "${@bb.utils.contains('DISTRO_FEATURES', 'sdp', '${WORKDIR}/secure_vpu.cfg', '', d)}"

addtask copy_defconfig after do_patch before do_preconfigure
do_copy_defconfig () {
    install -d ${B}
    if [ ${DO_CONFIG_V7_COPY} = "yes" ]; then
        # copy latest imx_v7_defconfig to use for mx6, mx6ul and mx7
        mkdir -p ${B}
        cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/.config
    else
        # copy latest defconfig to use for mx8
        mkdir -p ${B}
        cp ${S}/arch/arm64/configs/defconfig ${B}/.config
    fi

    if [ ! -z ${EXTRA_KERNEL_CONFIG} ]; then
        echo "\n" >> ${B}/.config
        cat ${EXTRA_KERNEL_CONFIG} >> ${B}/.config
    fi
    cp ${B}/.config ${B}/../defconfig
}

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
