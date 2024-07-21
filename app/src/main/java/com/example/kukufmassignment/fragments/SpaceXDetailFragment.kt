package com.example.kukufmassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kukufmassignment.R
import com.example.kukufmassignment.base.BaseFragment
import com.example.kukufmassignment.databinding.FragmentSpaceXDetailBinding
import com.example.kukufmassignment.model.SpaceXItem
import com.example.kukufmassignment.utils.CommonUtils
import com.example.kukufmassignment.viewmodel.MainViewModel
import com.example.kukufmassignment.viewmodel.SpaceXDetailViewModel


class SpaceXDetailFragment : BaseFragment<FragmentSpaceXDetailBinding, SpaceXDetailViewModel>(R.layout.fragment_space_x_detail) {

    override val viewModel: SpaceXDetailViewModel by viewModels()

    private lateinit var launchDetailData: SpaceXItem


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val args:  SpaceXDetailFragmentArgs by navArgs()
        launchDetailData = args.launchDetails
        renderDetailView(launchDetailData)
    }

    private fun renderDetailView(launchDetailData: SpaceXItem) {

        launchDetailData.flight_number?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.flight_no),
                it.toString()))
        }

        binding.llDetailContainer.addView(getCustomView(
            requireContext().getString(R.string.mission_name),
            launchDetailData.mission_name))

        launchDetailData.launch_date_utc?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.launch_date), CommonUtils.getDateTime(it)))
        }

        launchDetailData.rocket?.rocket_name?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.rocket_name), it))
        }

        launchDetailData.rocket?.rocket_id?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.rocket_id), it
            ))
        }

        launchDetailData.rocket?.rocket_type?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.rocket_type), it
            ))
        }

        launchDetailData.details?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.details), it
            ))
        }

        launchDetailData.rocket?.second_stage?.payloads?.let {payLoad ->
            if(payLoad.isNotEmpty()){
                payLoad[0]?.payload_id?.let {
                    binding.llDetailContainer.addView(getCustomView(
                        requireContext().getString(R.string.payloads_id), it))
                }

                payLoad[0]?.manufacturer?.let {
                    binding.llDetailContainer.addView(getCustomView(
                        requireContext().getString(R.string.manufacturer), it))
                }

                payLoad[0]?.nationality?.let {
                    binding.llDetailContainer.addView(getCustomView(
                        requireContext().getString(R.string.nationality), it))
                }

                payLoad[0]?.payload_type?.let {
                    binding.llDetailContainer.addView(getCustomView(
                        requireContext().getString(R.string.payload_type), it))
                }

                payLoad[0]?.payload_mass_kg?.let {
                    binding.llDetailContainer.addView(getCustomView(
                        requireContext().getString(R.string.payload_mass_kg), it.toString()))
                }

                payLoad[0]?.orbit?.let {
                    binding.llDetailContainer.addView(getCustomView(
                        requireContext().getString(R.string.orbit), it))
                }
                payLoad[0]?.orbit_params?.let {
                    it.apoapsis_km?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.apoapsis_km), it.toString()))
                    }
                    it.periapsis_km?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.periapsis_km), it.toString()))
                    }
                    it.semi_major_axis_km?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.semi_major_axis_km), it.toString()))
                    }
                    it.inclination_deg?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.inclination_deg), it.toString()))
                    }

                    it.lifespan_years?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.lifespan_years), it.toString()))
                    }

                    it.period_min?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.period_min), it.toString()))
                    }

                    it.reference_system?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.reference_system), it))
                    }

                    it.regime?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.regime), it))
                    }

                    it.longitude?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.longitude), it.toString()))
                    }

                    it.epoch?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.epoch), CommonUtils.getDateTime(it)))
                    }

                    it.mean_motion?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.mean_motion), it.toString()))
                    }

                    it.raan?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.raan), it.toString()))
                    }

                    it.arg_of_pericenter?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.arg_of_pericenter), it.toString()))
                    }

                    it.eccentricity?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.eccentricity), it.toString()))
                    }
                    it.mean_anomaly?.let {
                        binding.llDetailContainer.addView(getCustomView(
                            requireContext().getString(R.string.mean_anomaly), it.toString()))
                    }

                }

            }

        }

        launchDetailData.launch_site?.site_name?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.launch_site), it))
        }

        launchDetailData.launch_site?.site_id?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.site_id), it))
        }

        launchDetailData.launch_success?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.launch_success), it.toString()))
        }

        launchDetailData.launch_failure_details?.time?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.time), it.toString()))
        }

        launchDetailData.launch_failure_details?.altitude?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.altitude), it.toString()))
        }

        launchDetailData.launch_failure_details?.reason?.let {
            binding.llDetailContainer.addView(getCustomView(
                requireContext().getString(R.string.reason), it))
        }

        launchDetailData.links?.article_link?.let {
            binding.llDetailContainer.addView(getCustomLinkableView(
                requireContext().getString(R.string.article_link), it))
        }

        launchDetailData.links?.wikipedia?.let {
            binding.llDetailContainer.addView(getCustomLinkableView(
                requireContext().getString(R.string.wikipedia), it))
        }

        launchDetailData.links?.video_link?.let {
            binding.llDetailContainer.addView(getCustomLinkableView(
                requireContext().getString(R.string.video_link), it))
        }

    }

    private fun getCustomLinkableView(detailHeader: String, value: String?): View{
        val container = LayoutInflater.from(requireActivity()).inflate(R.layout.item_launch_detail,null )
       val tvDetailHeader =  container.findViewById<TextView>(R.id.tv_detail_header)
        val tvDetailBody =  container.findViewById<TextView>(R.id.tv_detail_body)
        tvDetailHeader.text = detailHeader
        tvDetailBody.text = value
        tvDetailBody.autoLinkMask = android.text.util.Linkify.WEB_URLS
        tvDetailBody.linksClickable = true
        return container

    }

    private fun getCustomView(detailHeader: String, value: String?): View{
        val container = LayoutInflater.from(requireActivity()).inflate(R.layout.item_launch_detail,null )
        container.findViewById<TextView>(R.id.tv_detail_header).text = detailHeader
        container.findViewById<TextView>(R.id.tv_detail_body).text = value
        return container
    }

}